# encoding:utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#

require_relative '../modelo_laberinto/laberinto.rb'
require_relative '../modelo_laberinto/habitacion.rb'
require_relative '../modelo_laberinto/elemento_separador.rb'
require_relative 'estado_juego.rb'

module Controlador_laberinto
  class Controlador

    attr_reader :estado, :vidas, :habitacion_usuario

    def initialize (modelo)
      @modelo = modelo
      @vidas = 0
      @estado = Estado_juego::EN_ENTRADA_LABERINTO
      @habitacion_usuario = nil

    end

    def entrar (vidas)
      @vidas = vidas
      @estado = Estado_juego::DENTRO_VIVO
      puerta = @modelo.puerta_entrada
      @habitacion_usuario = puerta.habitacion_al_otro_lado(nil)
      pared = Elemento_separador.nueva_pared(@habitacion_usuario, nil)
      @habitacion_usuario.set_lado(Direccion::SUR, pared)

    end

    def intentar_avanzar()
      direccion = rand(4)
      puedo_pasar = @habitacion_usuario.pasar(direccion)

      if puedo_pasar
        lado = @habitacion_usuario.get_lado(direccion)
        @habitacion_usuario = lado.habitacion_al_otro_lado(@habitacion_usuario)
        if @habitacion_usuario == nil
          @estado = Estado_juego::EN_SALIDA_LABERINTO
        end
      else
        @vidas -= 1

        if @vidas < 1
          @estado = Estado_juego::DENTRO_MUERTO
        end

      end
      return direccion
    end

  end

end
