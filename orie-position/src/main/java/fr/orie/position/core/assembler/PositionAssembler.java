package fr.orie.position.core.assembler;

import fr.orie.position.core.model.PointModel;
import fr.orie.position.core.model.PositionModel;
import fr.orie.position.core.model.PointPositionModel;
import fr.orie.position.persistence.PositionEntity;
import org.springframework.stereotype.Component;

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

