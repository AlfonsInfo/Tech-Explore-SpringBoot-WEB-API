package restfulAPI.restful.service;

import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import restfulAPI.restful.dto.request.CreateContactRequest;
import restfulAPI.restful.dto.request.SearchContactRequest;
import restfulAPI.restful.dto.request.UpdateContactRequest;
import restfulAPI.restful.dto.response.ContactResponse;
import restfulAPI.restful.entity.User;

public interface ContactService {

    public ContactResponse create(User user, CreateContactRequest request);
    public ContactResponse get(User user, String id);

    public ContactResponse update(User user, UpdateContactRequest request );

    public void delete(User user, String ContactId);


    public Page<ContactResponse> search(User user, SearchContactRequest request);

}
