package restfulAPI.restful.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import restfulAPI.restful.dto.request.CreateAddressRequest;
import restfulAPI.restful.dto.request.CreateContactRequest;
import restfulAPI.restful.dto.response.AddressResponse;
import restfulAPI.restful.dto.response.ContactResponse;
import restfulAPI.restful.dto.response.WebResponse;
import restfulAPI.restful.entity.User;
import restfulAPI.restful.service.AddressService;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;
    @PostMapping(
            path = "/api/contacts/{idContact}/address",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<AddressResponse> create(User user,
                                               @RequestBody CreateAddressRequest request,
                                               @PathVariable(name = "idContact") String idContact)
    {
        request.setContactId(idContact);//jsonIgnore ? mengabaikan data dari json
        AddressResponse addressResponse = addressService.create(user,request);
        //fungsi builder
        return WebResponse.<AddressResponse>builder().data(addressResponse).build();
    }


}
