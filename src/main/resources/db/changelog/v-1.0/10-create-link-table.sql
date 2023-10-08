CREATE TABLE Link (
    id bigserial not null primary key,
    created_at timestamp(6) not null,
    link varchar(4096) not null,
    owner_id bigint references person (id),
    visits bigint not null,
    UNIQUE(owner_id, id));