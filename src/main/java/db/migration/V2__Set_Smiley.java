package db.migration;

import de.kimrudolph.dbmigrations.SmileyUtil;
import de.kimrudolph.dbmigrations.DemoEntity;
import de.kimrudolph.dbmigrations.DemoEntityRepository;
import de.kimrudolph.dbmigrations.SpringContextUtil;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

public class V2__Set_Smiley extends BaseJavaMigration {

    SmileyUtil smileyUtil = SpringContextUtil
            .getBean(SmileyUtil.class);

    DemoEntityRepository demoEntityRepository = SpringContextUtil
            .getBean(DemoEntityRepository.class);

    @Override
    public void migrate(final Context context) {

        Iterable<DemoEntity> all = demoEntityRepository.findAll();

        for (DemoEntity demoEntity : all) {
            demoEntity.setSmiley(smileyUtil.smile());
        }

        demoEntityRepository.saveAll(all);
    }
}
