package io.pragra.learning.novspringjpa.aop;

import io.pragra.learning.novspringjpa.dto.ResponseDTO;
import io.pragra.learning.novspringjpa.util.AppConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ResponseDTO> exceptionHandler(Exception ex){
        // logger.error(dadsjncsdjchbnsjxsnckjndcds)
        ResponseDTO responseDTO = new ResponseDTO(
                null,
                AppConstants.NOV_SPRING_JPA_FAILURE,
                AppConstants.NOV_SPRING_JPA_FAILURE_DESC+ " " + ex.getMessage());
        ResponseEntity<ResponseDTO> responseEntity = ResponseEntity
                .ok()
                .header("asdsa","asdsfdfsdf")
                .body(responseDTO);
        return responseEntity;
    }
}
