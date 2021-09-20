package com.example.emppay.exception;
import com.example.emppay.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class EmployeePayrollExceptionHandler{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException (
            MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream()
                .map(objErr -> objErr.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST Request", errMsg);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmployeePayrollException.class)
    public ResponseEntity<ResponseDTO> handleAddressBookException(EmployeePayrollException exception) {
        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST Request",
                exception.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
