package hello.world.app.model;

import org.jooq.Field;
import org.jooq.Table;
import org.jooq.impl.DSL;

public final class User {
    private User() {}

    // Tables
    public static final Table<?> USERS  = DSL.table("users");

    // Users fields
    public static final Field<Long>          U_ID         = DSL.field("id", Long.class);
    public static final Field<String>        U_EMAIL      = DSL.field("email", String.class);
    public static final Field<String>        U_NAME       = DSL.field("name", String.class);
}