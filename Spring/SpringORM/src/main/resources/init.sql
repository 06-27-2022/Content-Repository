create table if not exists polkaman(
    polkaman_id serial primary key,
    polka_name text not null,
    polka_type text not null,
    polka_trainer text not null
);