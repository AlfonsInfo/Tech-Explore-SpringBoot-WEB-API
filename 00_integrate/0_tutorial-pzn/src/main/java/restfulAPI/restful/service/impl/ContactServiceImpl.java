package restfulAPI.restful.service.impl;


//import jakarta.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import restfulAPI.restful.dto.request.CreateContactRequest;
import restfulAPI.restful.dto.request.SearchContactRequest;
import restfulAPI.restful.dto.request.UpdateContactRequest;
import restfulAPI.restful.dto.response.ContactResponse;
import restfulAPI.restful.entity.Contact;
import restfulAPI.restful.entity.User;
import restfulAPI.restful.repository.ContactRepository;
import restfulAPI.restful.service.ContactService;
import restfulAPI.restful.service.ValidationService;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Service
public class ContactServiceImpl  implements ContactService {
    @Autowired
    private ContactRepository contactRepository;


    @Autowired
    private ValidationService validationService;


    private ContactResponse toContactResponse(Contact contact)
    {
        return ContactResponse.builder()
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .phone(contact.getPhone())
                .email(contact.getEmail())
                .build();
    }

    //Untuk create membutuhkan informasi sekarang yang lagi login
    @Transactional
    public ContactResponse create(User user, CreateContactRequest request)
    {
        //Validasi
        validationService.validate(request);

        //Core Create
        Contact contact = new Contact();
        contact.setId(UUID.randomUUID().toString());
        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setPhone(request.getPhone());
        contact.setEmail(request.getEmail());
        contact.setUser(user);
        contactRepository.save(contact);

        return toContactResponse(contact);
    }

    //Mengambil Contact Informasi Pribadi , bukan orang lain
    @Transactional
    @Override
    public ContactResponse get(User user, String id)
    {
        Contact contact = contactRepository.findFirstByUserAndId(user,id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact Not Found"));

        return toContactResponse(contact);
    }

    @Override
    @Transactional
    public ContactResponse update(User user, UpdateContactRequest request) {
        validationService.validate(request);

        Contact contact = contactRepository.findFirstByUserAndId(user, request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact Not found"));

        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setPhone(request.getPhone());
        contact.setEmail(request.getEmail());
        contactRepository.save(contact);

        return toContactResponse(contact);
    }

    @Override
    @Transactional
    public void delete(User user, String contactId) {
        Contact contact = contactRepository.findFirstByUserAndId(user, contactId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact Not found"));
        contactRepository.delete(contact);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<ContactResponse> search(User user, SearchContactRequest request) {
        Specification<Contact> specification = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(builder.equal(root.get("user"), user));
            if (Objects.nonNull(request.getName())) {
                predicates.add(builder.or(
                        builder.like(root.get("firstName"), "%" + request.getName() + "%"),
                        builder.like(root.get("lastName"), "%" + request.getName() + "%")
                ));
            }
            if (Objects.nonNull(request.getEmail())) {
                predicates.add(builder.like(root.get("email"), "%" + request.getEmail() + "%"));
            }
            if (Objects.nonNull(request.getPhone())) {
                predicates.add(builder.like(root.get("phone"), "%" + request.getPhone() + "%"));
            }

            return query.where(predicates.toArray(new Predicate[]{})).getRestriction();
        };

        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
        Page<Contact> contacts = contactRepository.findAll(specification, pageable);
        List<ContactResponse> contactResponses = contacts.getContent().stream()
                .map(this::toContactResponse)
                .toList();

        return new PageImpl<>(contactResponses, pageable, contacts.getTotalElements());
    }
}
