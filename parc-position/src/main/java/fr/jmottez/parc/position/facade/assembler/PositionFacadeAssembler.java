package fr.jmottez.parc.position.facade.assembler;

import fr.jmottez.parc.position.core.model.PointModel;
import fr.jmottez.parc.position.core.model.PointPositionModel;
import fr.jmottez.parc.position.core.model.PositionModel;
import fr.jmottez.parc.position.facade.dto.PointDTO;
import fr.jmottez.parc.position.facade.dto.PointPositionDTO;
import fr.jmottez.parc.position.facade.dto.PositionDTO;
import org.springframework.stereotype.Component;

@Component
public class PositionFacadeAssembler {

    public PositionDTO toDto(PositionModel model) {
        if (model instanceof PointPositionModel) {
            return toPointPositionDto((PointPositionModel) model);
        }
        throw new IllegalArgumentException("not manage this model:" + model.getClass().getSimpleName());
    }

    private PointPositionDTO toPointPositionDto(PointPositionModel model) {
        PointPositionDTO dto = new PointPositionDTO();
        dto.setUuid(model.getUuid());
        dto.setPoint(toPointDto(model.getPoint()));
        return dto;
    }

    private PointDTO toPointDto(PointModel model) {
        PointDTO dto = new PointDTO();
        dto.setLat(model.getLat());
        dto.setLng(model.getLng());
        return dto;
    }

    public PositionModel fromDto(PositionDTO dto) {
        if (dto instanceof PointPositionDTO) {
            return fromPointPositionDto((PointPositionDTO) dto);
        }
        throw new IllegalArgumentException("not manage this dto:" + dto.getClass().getSimpleName());

    }

    private PointPositionModel fromPointPositionDto(PointPositionDTO dto) {
        PointPositionModel model = new PointPositionModel();
        model.setUuid(dto.getUuid());
        model.setPoint(fromPointDto(dto.getPoint()));
        return model;
    }

    private PointModel fromPointDto(PointDTO dto) {
        PointModel model = new PointModel();
        model.setLat(dto.getLat());
        model.setLng(dto.getLng());
        return model;
    }

}
