-- Insert Gerente entities
INSERT INTO management.gerente (matricula, nome, setor, telefone, email, pwd) VALUES
  (1, 'John Doe', 'Finance', '1234567890', 'john.doe@example.com', 'password1'),
  (2, 'Jane Smith', 'Human Resources', '9876543210', 'jane.smith@example.com', 'password2'),
  (3, 'Mike Johnson', 'Operations', '5555555555', 'mike.johnson@example.com', 'password3');

-- Insert Funcionario entities
INSERT INTO management.funcionario (matricula, nome, telefone, email, gerente_id) VALUES
  (1, 'Alice Brown', '1111111111', 'alice.brown@example.com', 1),
  (2, 'Bob Davis', '2222222222', 'bob.davis@example.com', 1),
  (3, 'Carol Evans', '3333333333', 'carol.evans@example.com', 2),
  (4, 'David Green', '4444444444', 'david.green@example.com', 2),
  (5, 'Eve Harris', '5555555555', 'eve.harris@example.com', 3);

-- Insert Tarefa entities
INSERT INTO management.tarefa (id, titulo, descricao, status, gerente_id, funcionario_id) VALUES
  (1, 'Task 1', 'Complete task 1', 'In Progress', 1, 1),
  (2, 'Task 2', 'Complete task 2', 'Completed', 1, 2),
  (3, 'Task 3', 'Complete task 3', 'Pending', 2, 3),
  (4, 'Task 4', 'Complete task 4', 'In Progress', 2, 4),
  (5, 'Task 5', 'Complete task 5', 'Pending', 3, 5);