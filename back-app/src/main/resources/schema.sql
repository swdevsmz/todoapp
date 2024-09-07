create table if not exists todo (
    id identity,
    summary varchar(30),
    done boolean,
    created_at timestamp
);