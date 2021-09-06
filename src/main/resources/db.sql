
drop table if exists orders;
create table orders(
    id serial primary key,
    order_number int,
    consumer_email varchar(50),
    create_date date
);
drop table if exists product;
create table product(
    price decimal,
    delete boolean default false,
    article int not null,
    title varchar(50),
    id serial primary key
);
create table product_orders(
    order_id int not null,
    product_id int not null,
    id serial,
    primary key (order_id,product_id),
    foreign key (order_id) references orders(id) ON delete cascade,
    foreign key (product_id) references product(id) on delete cascade
                           );


