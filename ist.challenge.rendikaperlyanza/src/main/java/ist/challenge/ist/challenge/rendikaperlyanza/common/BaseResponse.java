package ist.challenge.ist.challenge.rendikaperlyanza.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = 753218915224057413L;
    private String responseKey;
    private HttpStatus status;
    private Object Data;
    public static BaseResponse builder(String message, HttpStatus ok,Object Data) {
        return new BaseResponse(message,ok,Data);
    }
}
