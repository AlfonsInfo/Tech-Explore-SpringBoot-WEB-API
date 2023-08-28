package restfulAPI.restful.utils.logging;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restfulAPI.restful.repository.LogRepository;

import java.util.logging.LogManager;

@Service
public class LogHelperUtil {

    private Logger  logger;

//    private Gson gson = new Gson();

//    private LogTrx log = new LogTrx();
    public LogHelperUtil(){
//        this.logger = LogManager.getLogger();
    }

    @Autowired
    LogRepository logRepository;
}
