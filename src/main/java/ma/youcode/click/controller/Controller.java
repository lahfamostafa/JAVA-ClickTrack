package ma.youcode.click.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.youcode.click.dto.ClickDto;
import ma.youcode.click.dto.OffreDto;
import ma.youcode.click.dto.RequestDto;
import ma.youcode.click.entity.*;

import ma.youcode.click.service.*;

@RestController 
@RequestMapping("api")
public class Controller{
    
    private final PublisherService publisherService;
    private final LienService lienService;
    public Controller(PublisherService publisherService , LienService lienService){
        this.publisherService = publisherService;
        this.lienService = lienService;
    }

    @GetMapping("/publishers")
    public List<Publisher> findAllPublishers(){
        return publisherService.findAll();
    }

    @GetMapping("/publishers/{id}")
    public ResponseEntity<Publisher> findById(@PathVariable("id") int id){
        Optional<Publisher> publisher = publisherService.findById(id);

        return publisher
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // -------Publisher------- //


    @GetMapping("/liens")
    public ResponseEntity<List<ClickDto>> findAllLiens(){
        return ResponseEntity.ok(lienService.findAll());
    }

    @GetMapping("/publishers/{id}/offres")
    public ResponseEntity<List<OffreDto>> getOffresForPublisher(@PathVariable("id")int publisherId){
        List<OffreDto> liens = lienService.getOffresForPublisher(publisherId);
        return ResponseEntity.ok(liens);
    }

    @GetMapping("/publishers/{id}/liens")
    public ResponseEntity<List<ClickDto>> getLiensForPublisher(@PathVariable("id") int publisherId){
        List<ClickDto> liens = lienService.getLiensForPublisher(publisherId);
        return ResponseEntity.ok(liens);
    }

    @PostMapping("/publishers/{id}/liens")
    public ResponseEntity<ClickDto> createLien(@PathVariable("id") int publisherId , @RequestBody RequestDto reqDto){
        Lien lien = lienService.save(reqDto , publisherId);
        ClickDto clickDto = new ClickDto(lien.getId(), lien.getUrlDestination(), (long)lien.getClicks(), lien.getPublisher().getNom()+" "+lien.getPublisher().getPrenom(), "t/"+lien.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(clickDto);
    }

    // -------Lien------- //

    @PostMapping("/t/{id}")
    public ResponseEntity<Lien> incrementer(@PathVariable("id") int lienId){
        Optional<Lien> lien = lienService.incrementer(lienId);
        return lien.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
