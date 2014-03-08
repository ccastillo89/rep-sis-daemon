-- Insert para la llenar la tabla codigo, colocar los codigo que faltan


insert into Codigo(
  Descripcion_Codigo,
  IdGrupo,
  Grupo)
  Values('Administrador', 1, 'Roles'),
  ('Supervisor', 1, 'Roles'),
  ('Asesor', 1, 'Roles'),
  ('Estudiante', 1, 'Roles'),
  ('Evaluador de Innovador', 1, 'Roles'),
  ('Publicada', 2, 'Estado_Aprobacion'),
  ('Aprobada', 2, 'Estado_Aprobacion'),
  ('Rechazada', 2, 'Estado_Aprobacion')