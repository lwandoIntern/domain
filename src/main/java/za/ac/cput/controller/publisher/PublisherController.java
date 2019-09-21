package za.ac.cput.controller.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.ResponseObject;
import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.publisher.Publisher;
import za.ac.cput.domain.publisher.PublisherAddress;
import za.ac.cput.domain.request.NewPublisher;
import za.ac.cput.factory.ResponseObjectFactory;
import za.ac.cput.factory.publisher.PublisherAddressFactory;
import za.ac.cput.factory.publisher.PublisherFactory;
import za.ac.cput.service.location.impl.AddressServiceImpl;
import za.ac.cput.service.publisher.PublisherAddressService;
import za.ac.cput.service.publisher.impl.PublisherServiceImpl;

@RestController
@RequestMapping("/domain/publisher")
public class PublisherController {
    @Autowired
    PublisherServiceImpl publisherService;
    @Autowired
    AddressServiceImpl addressService;
    @Autowired
    PublisherAddressService publisherAddressService;

    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createPublisher(@RequestBody NewPublisher newPublisher){
        System.out.println(newPublisher);
        ResponseObject responseObject = ResponseObjectFactory.buildGenericResponseObject(HttpStatus.OK.toString(),"Publisher created!");
        if (newPublisher.getPublisherName() == null || newPublisher.getPublisherName() == null){
            responseObject.setResponse(HttpStatus.PRECONDITION_FAILED.toString());
            responseObject.setResponseDescription("Please provide a publisher name and/or publishers\' town.");
        }else {
            Address address = getAddress(newPublisher);
            if (address == null){
                String message = address == null ? "Address not found": "";
                responseObject.setResponseDescription(message);
            }else {
                Publisher thePublisher = savePublisher(newPublisher);
                PublisherAddress savePublAddr = savePublisherAddress(thePublisher,address);
                responseObject.setResponse(thePublisher);
            }
        }
        return ResponseEntity.ok(responseObject);
    }
    private Publisher savePublisher(NewPublisher newPublisher){
        return publisherService.create(
                PublisherFactory.createPublisher(newPublisher.getPublisherName()));
    }
    private PublisherAddress savePublisherAddress(Publisher publisher,Address address){
        return publisherAddressService.create(
                PublisherAddressFactory.createPublisherAddress(publisher.getPublisherId(),address.getAddressId()));
    }
    private Address getAddress(NewPublisher newPublisher){
        return addressService.getByTown(newPublisher.getPublisherAddress());
    }
}
