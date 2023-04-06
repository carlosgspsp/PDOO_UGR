# encoding:utf-8

require_relative './controlador_laberinto/controlador.rb'
require_relative './controlador_laberinto/estado_juego.rb'
class Vista_laberinto

  def initialize (controlador)
    @controlador = controlador
  end

  def menu_usuario ()
    if @controlador.estado == Controlador_laberinto::Estado_juego::EN_ENTRADA_LABERINTO
      print "\nIntroduzca el numero de vidas con el que desea comenzar (1-10): "
      nvidas = gets.chomp

      while nvidas.to_i < 1 || nvidas.to_i > 10
        print "\nEl numero de vidas introducido es incorrecto, vuelva a introducir el numero de vidas con el que desea comenzar (1-10): "
        nvidas = gets.chomp
      end
      @controlador.entrar(nvidas.to_i)

    elsif @controlador.estado == Controlador_laberinto::Estado_juego::DENTRO_VIVO
      informe_dentro(@controlador.habitacion_usuario, @controlador.vidas)
      print "\n Pulse Enter para continuar"
      gets.chomp
      print "\n"+Lista_direcciones[@controlador.intentar_avanzar]



    elsif @controlador.estado == Controlador_laberinto::Estado_juego::EN_SALIDA_LABERINTO || @controlador.estado == Controlador_laberinto::Estado_juego::DENTRO_MUERTO
      informe_final(@controlador.vidas)
      exit 0

    end

    menu_usuario
  end

  def informe_dentro (habitacion, vidas)
    print "\nEl jugador se encuentra en la habitacion " + habitacion.to_s + " y tiene " + vidas.to_s + " vidas"
  end

  def informe_final (vidas)
    print "\nEl jugador tiene " + vidas.to_s + " vidas"
  end

end