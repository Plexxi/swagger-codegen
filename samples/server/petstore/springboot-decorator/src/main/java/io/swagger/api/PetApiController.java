package io.swagger.api;

import java.io.File;
import io.swagger.model.ModelApiResponse;
import io.swagger.model.Pet;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;



@Controller
public class PetApiController implements PetApi {
    private final PetApiDecorator decorator;

    @org.springframework.beans.factory.annotation.Autowired
    PetApiController(PetApiDecorator decorator) {
        this.decorator = decorator;
    }


    public ResponseEntity<Void> addPet(@ApiParam(value = "Pet object that needs to be added to the store" ,required=true ) @RequestBody Pet body) {
        // do some magic!
        return decorator.addPet(body);
    }

    public ResponseEntity<Void> deletePet(@ApiParam(value = "Pet id to delete",required=true ) @PathVariable("petId") Long petId,
        @ApiParam(value = ""  ) @RequestHeader(value="api_key", required=false) String apiKey) {
        // do some magic!
        return decorator.deletePet(petId, apiKey);
    }

    public ResponseEntity<List<Pet>> findPetsByStatus(@ApiParam(value = "Status values that need to be considered for filter", required = true, allowableValues = "AVAILABLE, PENDING, SOLD") @RequestParam(value = "status", required = true) List<String> status) {
        // do some magic!
        return decorator.findPetsByStatus(status);
    }

    public ResponseEntity<List<Pet>> findPetsByTags(@ApiParam(value = "Tags to filter by", required = true) @RequestParam(value = "tags", required = true) List<String> tags) {
        // do some magic!
        return decorator.findPetsByTags(tags);
    }

    public ResponseEntity<Pet> getPetById(@ApiParam(value = "ID of pet to return",required=true ) @PathVariable("petId") Long petId) {
        // do some magic!
        return decorator.getPetById(petId);
    }

    public ResponseEntity<Void> updatePet(@ApiParam(value = "Pet object that needs to be added to the store" ,required=true ) @RequestBody Pet body) {
        // do some magic!
        return decorator.updatePet(body);
    }

    public ResponseEntity<Void> updatePetWithForm(@ApiParam(value = "ID of pet that needs to be updated",required=true ) @PathVariable("petId") Long petId,
        @ApiParam(value = "Updated name of the pet" ) @RequestPart(value="name", required=false)  String name,
        @ApiParam(value = "Updated status of the pet" ) @RequestPart(value="status", required=false)  String status) {
        // do some magic!
        return decorator.updatePetWithForm(petId, name, status);
    }

    public ResponseEntity<ModelApiResponse> uploadFile(@ApiParam(value = "ID of pet to update",required=true ) @PathVariable("petId") Long petId,
        @ApiParam(value = "Additional data to pass to server" ) @RequestPart(value="additionalMetadata", required=false)  String additionalMetadata,
        @ApiParam(value = "file detail") @RequestPart("file") MultipartFile file) {
        // do some magic!
        return decorator.uploadFile(petId, additionalMetadata, file);
    }

}
