package restfulAPI.restful.entity.exception;

import lombok.*;

import java.io.Serial;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GeneralCustomException extends RuntimeException{

    //@Serial How it works ??
    //private static final long serialVersionUID = 8323271231831929292L;


    protected  String errorCode;


    public GeneralCustomException(String errorCode) {
        this.errorCode = errorCode;
    }

    public void testMethod()
    {
        //GeneralCustomException test = new GeneralCustomException();
        //test.get
    }
}
