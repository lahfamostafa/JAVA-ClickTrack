package ma.youcode.click.repository.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import ma.youcode.click.dto.ClickDto;
import ma.youcode.click.dto.OffreDto;
import ma.youcode.click.entity.Lien;
import ma.youcode.click.entity.Publisher;
import ma.youcode.click.repository.*;

public class LienRepositoryImpl implements LienRepository {

    private final List<Lien> liens = new ArrayList<>();
    private int nextId = 1;

    @Override
    public Lien save(Lien lien) {
        lien.setId(nextId++);
        lien.setClicks(0);
        liens.add(lien);
        return lien;
    }

    @Override
    public List<ClickDto> getLiensForPublisher(Publisher publisher) {
        return liens.stream()
        .filter(p->p.getPublisher().getId() == publisher.getId())
        .map(lien -> new ClickDto(
            lien.getId(), 
            lien.getUrlDestination(), 
            (long)lien.getClicks(), 
            lien.getPublisher().getNom()+" "+lien.getPublisher().getPrenom(), 
            "t/"+lien.getId()))
        .toList();
    }

    @Override
    public List<OffreDto> getOffresForPublisher(int publisherId) {
        Map<String,List<Lien>> map = liens.stream().filter(lien-> lien.getPublisher().getId() == publisherId).collect(Collectors.groupingBy(Lien::getOffre));
        List<OffreDto> offreDtos = new ArrayList<>();
        for (Map.Entry<String,List<Lien>> m : map.entrySet()) {
            String offre = m.getKey();
            List<Lien> liensOffre = m.getValue();
            Long nombreLiens = (long)liensOffre.size();
            int clicks = liensOffre.stream().mapToInt(Lien::getClicks).sum();
            offreDtos.add(new OffreDto(offre, nombreLiens, clicks));
        }

        return offreDtos;
    }

    @Override
    public Optional<Lien> findById(int id) {
        return liens.stream().filter(i->i.getId() == id).findFirst();
    }

    @Override
    public List<ClickDto> findAll() {
        return liens.stream()
            .map(lien -> new ClickDto(
                lien.getId(), 
                lien.getUrlDestination(), 
                (long)lien.getClicks(), 
                lien.getPublisher().getNom()+" "+lien.getPublisher().getPrenom(), 
                "t/"+lien.getId()))
            .toList();
    }

    @Override
    public Optional<Lien> incremente(int lienId) {
        Optional<Lien> lien = liens.stream().filter(link -> link.getId() == lienId).findFirst();
        int cliks = lien.get().getClicks();
        lien.get().setClicks(++cliks);
        return lien;
    }
    
}
