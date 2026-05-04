package com.Unicartagena.TCC.base.utils;

import com.Unicartagena.TCC.base.configs.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseDTOService {
    public ResponseEntity<?> response(Object data, HttpStatus status){
        ResponseDTO<?> responseDTO = new ResponseDTO<>(status.value(), status.getReasonPhrase(), data);
        return new ResponseEntity<>(responseDTO, status);
    }
    public ResponseEntity<?> response(HttpStatus status){
        ResponseDTO<?> responseDTO = new ResponseDTO<>(status.value(), status.getReasonPhrase());
        return new ResponseEntity<>(responseDTO, status);
    }
}
