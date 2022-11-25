package com.sofia.festapi.controller;

import com.sofia.festapi.dto.FestDTO;
import com.sofia.festapi.exception.FestAPIException;
import com.sofia.festapi.service.FestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class FestController {
    FestService festService;

    @GetMapping("/fest")
    public ResponseEntity<FestDTO> getFestDetails(@RequestParam("festId") String festId) throws FestAPIException {
        return new ResponseEntity<>(festService.getFestDTOById(festId), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addNewFest(@RequestBody FestDTO festDTO) {
        festService.addNewFest(festDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
