package ma.youcode.click.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.youcode.click.dto.OffreDto;
import ma.youcode.click.dto.RequestDto;
import ma.youcode.click.entity.Lien;
import ma.youcode.click.service.*;

@RestController 
@RequestMapping("api/publishers")
public class LienController {

    private final LienService lienService;
    public LienController(LienService lienService){
        this.lienService = lienService;
    }

    @GetMapping("/liens")
    public ResponseEntity<List<Lien>> findAll(){
        return ResponseEntity.ok(lienService.findAll());
    }
    
    // @GetMapping("/lien/{id}")
    // public ResponseEntity<Lien> findById(@PathVariable("id") int id){
    //     Optional<Lien> lien = lienService.findById(id);

    //     return lien.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    // }

    @GetMapping("/{id}/offres")
    public ResponseEntity<List<OffreDto>> getOffresForPublisher(@PathVariable("id")int publisherId){
        List<OffreDto> liens = lienService.getOffresForPublisher(publisherId);
        return ResponseEntity.ok(liens);
    }

    @GetMapping("/{id}/liens")
    public ResponseEntity<List<Lien>> getLiensForPublisher(@PathVariable("id") int publisherId){
        List<Lien> liens = lienService.getLiensForPublisher(publisherId);
        return ResponseEntity.ok(liens);
    }

    @PostMapping("/{id}/liens")
    public ResponseEntity<Lien> createLien(@PathVariable("id") int publisherId , @RequestBody RequestDto reqDto){
        Lien lien = lienService.save(reqDto , publisherId);
        return ResponseEntity.status(HttpStatus.CREATED).body(lien);
    }
    
}
