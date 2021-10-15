CREATE OR REPLACE FUNCTION seleccionaTodoCategoria() RETURNS Table(
    idCategoria int,
    nombreCategoria varchar,
    descripcionCategoria varchar
) AS $$
    SELECT * FROM Categoria;
$$ LANGUAGE sql

select * from seleccionaTodoCategoria();

create or replace procedure spInsertarCategoria(
    in nombre varchar,
    in descripcion varchar
)
language sql 
as $$
    insert into Categoria (nombreCategoria, descripcionCategoria) values (nombre, descripcion);
$$
call spInsertarCategoria('Categoria 1', 'Categporia 1');

create or replace procedure spActualizarCategoria(
    in nombre varchar,
    in descripcion varchar,
    in id int
)
language sql 
as $$
    update  Categoria set nombreCategoria = nombre, descripcionCategoria = descripcion where idCategoria = id;
$$
call spActualizarCategoria('Categoria vhgjgj', 'jgjkgjkg', 4);

select * from categoria;