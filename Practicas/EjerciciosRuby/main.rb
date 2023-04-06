# encoding:utf-8
#
#

require_relative './controlador_laberinto/controlador.rb'
require_relative './modelo_laberinto/laberinto.rb'
require_relative 'vista2_laberinto.rb'
require_relative 'vista_laberinto.rb'
module EjerciciosRuby
  class Main
    def main
      laberinto=Modelo_laberinto::Laberinto.new
      controlador=Controlador_laberinto::Controlador.new(laberinto)
      vista = Vista_laberinto.new(controlador)
      #vista = Vista_laberinto.new(controlador,laberinto)

      vista.menu_usuario

    end

  end
  ejercicio=Main.new.main
end


