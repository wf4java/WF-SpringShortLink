package wf.spring.short_link.models.exceptions;

import org.springframework.http.HttpStatus;

public interface HttpException {

    public HttpStatus getHttpStatus();

    public String getMessage();

}
