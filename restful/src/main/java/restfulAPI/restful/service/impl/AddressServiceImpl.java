package restfulAPI.restful.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import restfulAPI.restful.dto.request.CreateAddressRequest;
import restfulAPI.restful.dto.response.AddressResponse;
import restfulAPI.restful.entity.Address;
import restfulAPI.restful.entity.Contact;
import restfulAPI.restful.entity.User;
import restfulAPI.restful.repository.AddressRepository;
import restfulAPI.restful.repository.ContactRepository;
import restfulAPI.restful.service.AddressService;
import restfulAPI.restful.service.ValidationService;

import java.util.UUID;
@Service
public class AddressServiceImpl implements AddressService {


    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ValidationService validationService;


    public AddressResponse toAddressResponse(Address address)
    {
        return AddressResponse.builder()
                .id(address.getId())
                .street(address.getStreet())
                .city(address.getCity())
                .province(address.getProvince())
                .country(address.getCountry())
                .build();
    }
    @Override
    public AddressResponse create(User user, CreateAddressRequest request) {
        validationService.validate(request);

        Contact contact = contactRepository.findFirstByUserAndId(user,request.getContactId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact is not found"));

        Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

//        logger.info("contact id dari objek contact" + contact.getId().toString());
//        logger.info("contact id dari request" + request.getContactId());

        Address address = new Address();
        address.setId(UUID.randomUUID().toString());
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setProvince(request.getProvince());
        address.setCountry(request.getCountry());
        address.setContact(contact);

        logger.info("id address" + address.getId());
        logger.info("contact id dari request" + contact.getId());
        //Bagian yang menyimpan ke Database
        addressRepository.save(address);

        return  toAddressResponse(address);
    }
}
