package fr.jmottez.parc.position.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PositionRepository {

    public Optional<PositionEntity> findByUuId(String uuId) {
        PositionEntity entity = new PositionEntity();
        entity.setLat(83.39f);
        entity.setLng(3.35f);
        entity.setUuId(uuId);
        return Optional.of(entity);
    }

    public PositionEntity save(PositionEntity positionEntity) {
        System.out.println("yeah save !!");
        return positionEntity;
    }

    public void delete(PositionEntity positionEntity) {
        System.out.println("Delete !!");
    }
}
