package fr.orie.scenario;

import fr.orie.scenario.persistence.entity.ScenarioEntity;
import fr.orie.scenario.persistence.entity.ScenarioNodeEntity;
import fr.orie.scenario.persistence.entity.target.AbstractScenarioNodeTargetEntity;
import fr.orie.scenario.persistence.entity.target.ScenarioNodeTargetItemPointEntity;
import fr.orie.scenario.persistence.entity.target.ScenarioNodeTargetListEntity;
import fr.orie.scenario.persistence.entity.target.ScenarioNodeTargetOperator;
import fr.orie.scenario.persistence.repository.ScenarioNodeRepository;
import fr.orie.scenario.persistence.repository.ScenarioNodeTargetRepository;
import fr.orie.scenario.persistence.repository.ScenarioRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class ScenarioApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ScenarioSpringConfiguration.class);

        ScenarioRepository scenarioRepository = (ScenarioRepository) context.getBean("scenarioRepository");
        ScenarioNodeRepository scenarioNodeRepository = (ScenarioNodeRepository) context.getBean("scenarioNodeRepository");
        ScenarioNodeTargetRepository scenarioNodeTargetRepository = (ScenarioNodeTargetRepository) context.getBean("scenarioNodeTargetRepository");

        ScenarioEntity scenario1 = new ScenarioEntity();
        scenarioRepository.save(scenario1);

        ScenarioNodeTargetItemPointEntity target1 = new ScenarioNodeTargetItemPointEntity();
        target1.setRadiusMeter(159);
        target1.setPointUuId("aaa");
        scenarioNodeTargetRepository.save(target1);

        ScenarioNodeTargetItemPointEntity target2 = new ScenarioNodeTargetItemPointEntity();
        target2.setRadiusMeter(28);
        target2.setPointUuId("bbb");
        scenarioNodeTargetRepository.save(target2);

        ScenarioNodeTargetListEntity targetList = new ScenarioNodeTargetListEntity();
        targetList.setOperator(ScenarioNodeTargetOperator.OR);
        targetList.getItems().add(target1);
        targetList.getItems().add(target2);
        scenarioNodeTargetRepository.save(targetList);

        ScenarioNodeEntity node1 = new ScenarioNodeEntity();
        node1.setScenario(scenario1);
        node1.setTarget(targetList);
        scenarioNodeRepository.save(node1);

        scenarioRepository.findAll().forEach(scenario -> System.out.println("scenario:id:" + scenario.getUuId()));
    }


}
