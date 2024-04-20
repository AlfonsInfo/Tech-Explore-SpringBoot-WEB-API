package restfulAPI.restful.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import restfulAPI.restful.dto.request.CreateAddressRequest;
import restfulAPI.restful.dto.request.CreateContactRequest;
import restfulAPI.restful.dto.request.SearchContactRequest;
import restfulAPI.restful.dto.request.UpdateContactRequest;
import restfulAPI.restful.dto.response.AddressResponse;
import restfulAPI.restful.dto.response.ContactResponse;
import restfulAPI.restful.entity.Address;
import restfulAPI.restful.entity.Contact;
import restfulAPI.restful.entity.User;


public interface AddressService {

    public AddressResponse create(User user, CreateAddressRequest request);
//    public AddressResponse get(User user, String id);
//
//    public ContactResponse update(User user, UpdateContactRequest request );
//
//    public void delete(User user, String ContactId);
//
//    public Page<ContactResponse> search(User user, SearchContactRequest request);
}
