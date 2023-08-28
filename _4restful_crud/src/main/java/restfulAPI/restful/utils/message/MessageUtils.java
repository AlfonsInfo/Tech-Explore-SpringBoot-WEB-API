package restfulAPI.restful.utils.message;

import org.springframework.beans.factory.annotation.Autowired;
import restfulAPI.restful.entity.ErrorDictionary;
import restfulAPI.restful.entity.constant.SingletonHashTable;
import restfulAPI.restful.entity.exception.GeneralCustomException;
import restfulAPI.restful.repository.ErrorMessageRepository;

import java.util.Hashtable;

public class MessageUtils {

    @Autowired
    private SingletonHashTable singletonHashTable;

    @Autowired
    private ErrorMessageRepository errorMessageRepository;


    public Hashtable<String, String> getErrMsgTable(String keyMessage) throws GeneralCustomException{
        Hashtable<String,String> errCodeHashTable = null;

//        if(singletonHashTable.getHashtable(keyMessage) == null)
//        {
//            Iterable<ErrorDictionary> errorDictionaries = errorMessageRepository.findAll();
//
//            String key = "";
//            String errCode = "";
//
//            for()
//        }

        return errCodeHashTable;
    }
}
