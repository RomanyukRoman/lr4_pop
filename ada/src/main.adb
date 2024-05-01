with Ada.Text_IO; use Ada.Text_IO;
with GNAT.Semaphores; use GNAT.Semaphores;

procedure Main is
   Forks : array(1..5) of Counting_Semaphore(1, Default_Ceiling);

   task type Philosopher is
      entry StartAsymetric(id : Integer);
   end Philosopher;

   task body Philosopher is
      id : Integer;
      id_right_fork : Integer;
      id_left_fork : Integer;
   begin
         accept StartAsymetric (id : in Integer) do
           Philosopher.id := id;
            if id rem 2 = 0 then
               id_left_fork := id;
               id_right_fork := id rem 5 + 1;
            else
               id_left_fork := id rem 5 + 1;
               id_right_fork := id;
            end if;
         end StartAsymetric;

      for i in 1..2 loop
         Put_Line ("Philosopher " & Id'Img & " is hungry " & I'Img & " time");

         Forks (Id_Left_Fork).Seize;
         Forks (Id_Right_Fork).Seize;

         Put_Line ("Philosopher " & Id'Img & " is eating" & I'Img & " time");

         Forks (Id_Right_Fork).Release;
         Forks (Id_Left_Fork).Release;

         Put_Line ("Philosopher " & Id'Img & " finished eating");
      end loop;
   end Philosopher;

   Philosophers : array(1..5) of Philosopher;
begin
   for i in Philosophers'Range loop
      Philosophers(i).StartAsymetric(i);
   end loop;
end Main;
