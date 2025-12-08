package hello.world.app.repository;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.SortField;
import org.jooq.impl.DSL;

public abstract class BaseRepository {
    protected final DSLContext dsl;

    protected BaseRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    protected Condition andLikeIgnoreCase(Condition base, org.jooq.Field<String> field, String contains) {
        if (contains == null || contains.isBlank()) return base;
        return base.and(field.likeIgnoreCase("%" + contains + "%"));
    }

    protected Condition andEquals(Condition base, org.jooq.Field<String> field, String equals) {
        if (equals == null || equals.isBlank()) return base;
        return base.and(field.eq(equals));
    }

    protected int offset(int page, int size) {
        return Math.max(page, 0) * Math.max(size, 1);
    }

    protected SortField<?> sort(org.jooq.Field<?> field, boolean asc) {
        return asc ? field.asc() : field.desc();
    }

    protected Condition alwaysTrue() { return DSL.trueCondition(); }
}
