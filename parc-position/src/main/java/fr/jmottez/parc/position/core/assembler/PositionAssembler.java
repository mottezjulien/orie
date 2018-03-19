package fr.jmottez.parc.position.core.assembler;

import fr.jmottez.parc.position.core.model.PointModel;
import fr.jmottez.parc.position.core.model.PositionModel;
import fr.jmottez.parc.position.core.model.PointPositionModel;
import fr.jmottez.parc.position.repository.PositionEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PositionAssembler {

    public PositionModel fromEntity(PositionEntity entity) {
        PointPositionModel pointPosition = new PointPositionModel();
        pointPosition.setUuid(entity.getUuId());
        PointModel point = new PointModel();
        point.setLat(entity.getLat());
        point.setLng(entity.getLng());
        pointPosition.setPoint(point);
        return pointPosition;
    }

    public PositionEntity toEntity(PositionModel model) {
        PositionEntity entity = new PositionEntity();
        if(model instanceof PointPositionModel) {
            PointPositionModel pointPositionModel = (PointPositionModel) model;
            entity.setUuId(pointPositionModel.getUuid());
            entity.setLat(pointPositionModel.getPoint().getLat());
            entity.setLng(pointPositionModel.getPoint().getLng());
        }
        return entity;
    }
}

