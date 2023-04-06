# encoding:utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.



 module Herencia
   class Persona
     def initialize(nombre)
       @nombre = nombre
     end

     def andar
       result = "Soy #{@nombre} y estoy andando"
     end


     def to_s
       result = "Soy una persona y mi nombre es #{@nombre}"
     end

   end


   class Deportista < Persona


     def initialize(nombre)
       super
       @horas_entrenamiento = 0
     end

     def competicion_deportiva
       result = "Estoy compitiendo"
     end


     def to_s
       result = super+", hago deporte y entreno #{@horas_entrenamiento} horas"
     end
   end

   class Corredor < Deportista
     def correr
       result = "Estoy corriendo"
     end


     def to_s
       result = super+", estoy corriendo"
     end
   end

   class Nadador < Deportista
     def nadar
       result = "Estoy nadando"
     end


     def to_s
       result = super+", estoy nadando"
     end
   end

   persona = Persona.new("Juan")
   deportista = Deportista.new("Nacho")
   corredor = Corredor.new("Jose Manu")
   nadador = Nadador.new("Jorge")

   puts persona.to_s
   puts deportista.to_s
   puts corredor.to_s
   puts nadador.to_s

   puts persona.andar
   puts deportista.andar
   puts corredor.andar
   puts nadador.andar

   #El constructor se hereda del padre si no hay constuctror propio, si hay atributos nuevos se deberian crear constructores nuevos para inicializar los atributos

   puts deportista.competicion_deportiva
   puts corredor.competicion_deportiva
   puts nadador.competicion_deportiva
   #El metodo padre y sus hijos pueden acceden sin problema a los metodos del padre


   puts corredor.correr
   puts nadador.nadar
   #Los metodos de los hijos no pueden ser accedidos ni por los hermanos ni por el padre
   #Los hijos tienen acceso a los atributos del padre y a los suyos propios, mientras que el padre solo tiene acceso a los suyos propios



 end
