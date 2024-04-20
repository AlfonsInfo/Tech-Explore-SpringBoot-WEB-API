package group.bootcamp.technicaltest.service;

import group.bootcamp.technicaltest.common.exception.CustomValidationException;
import group.bootcamp.technicaltest.dto.BaseResponse;
import group.bootcamp.technicaltest.dto.request.ReqRegisDto;
import group.bootcamp.technicaltest.entity.Account;
import group.bootcamp.technicaltest.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {


    private final AccountRepository accountRepository;

    @Autowired
    public RegistrationService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public BaseResponse<String,String> registerAccount(ReqRegisDto request){
        //* Validation
        validateNonDuplicateEmail(request);
        //* Register Account
        Account account = Account
                .builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .isEmailAlreadyVerified(false)
                .build();
        accountRepository.save(account);
        //* Send Email Verify

        BaseResponse<String, String> response = new BaseResponse<>();
        return response.successResponse(null,null);
    }

    private void validateNonDuplicateEmail(ReqRegisDto request) {
        if(accountRepository.existsByEmail(request.getEmail()).equals(Boolean.TRUE)){
            throw new CustomValidationException("Email duplikat");
        }
    }
}
