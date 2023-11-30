package ma.gov.cmr.echangeaf.controllers;

import lombok.RequiredArgsConstructor;
import ma.gov.cmr.echangeaf.dto.create.WsPasRequeteCreateDto;
import ma.gov.cmr.echangeaf.dto.response.WsPasRequeteResponseDto;
import ma.gov.cmr.echangeaf.service.IWsBeneficiaireService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/requete")
@RequiredArgsConstructor
public class WsBeneficiaireController {

    private final IWsBeneficiaireService wsBeneficiaireService;

    @PostMapping
    public ResponseEntity<Optional<WsPasRequeteResponseDto>> createWsPasRequete(@RequestBody WsPasRequeteCreateDto wsPasRequeteCreate) {
        return new ResponseEntity<>(wsBeneficiaireService.createWsPasRequete(wsPasRequeteCreate), HttpStatus.CREATED);
    }

}
