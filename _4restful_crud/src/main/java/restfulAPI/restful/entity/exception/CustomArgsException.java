package restfulAPI.restful.entity.exception;

import java.io.Serial;

public class CustomArgsException extends GeneralCustomException{


    @Serial
    private static final long serialVersionUID = 632131213139219219L;

    protected Object[] args;


    public CustomArgsException(String errorCode, Object... args)
    {
        this.errorCode = errorCode;
        this.args = args;
    }
}
