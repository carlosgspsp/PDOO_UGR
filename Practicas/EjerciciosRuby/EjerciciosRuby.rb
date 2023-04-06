# encoding:utf-8
class Parcela
=begin
  @@FACTORALQUILERCALLE = 1.0
  @@FACTORALQUILERCASA = 1.0
  @@FACTORALQUILERHOTEL = 4.0
=end

   @FACTORALQUILERCALLE = 1.0
   @FACTORALQUILERCASA = 1.0
   @FACTORALQUILERHOTEL = 4.0
  # He tenido que añadir nuevos metodos para consultar estas variables de instacia de clase porque si no
  # incluyera nuevos metodos el compilador buscaria las variables en las variables de instancia de objeto.
  # Por el mismo moivo los consultores tienen que ser de clase.
  # Para invocar los metodos desde el metodo precio_alquiler_completo se hace igual que cualquier metodo de clase
  # Parcela.metodo

  def initialize (nombre, precio_compra, precio_edificacion, precio_alquiler_base)

    @nombre = nombre
    @precio_compra = precio_compra
    @precio_edificacion = precio_edificacion
    @precio_alquiler_base = precio_alquiler_base
    @num_casas = 0
    @num_hoteles = 0
  end

  attr_reader :nombre, :precio_compra, :precio_edificacion, :num_casas, :num_hoteles

  def self.FACTORALQUILERCALLE
    @FACTORALQUILERCALLE
  end

  def self.FACTORALQUILERCASA
    @FACTORALQUILERCASA
  end

  def self.FACTORALQUILERHOTEL
    @FACTORALQUILERHOTEL
  end
  def precio_alquiler_completo
    # alquiler = @precio_alquiler_base* @@FACTORALQUILERCALLE*(1+@num_casas*@@FACTORALQUILERCASA+@num_hoteles*@@FACTORALQUILERHOTEL)
     alquiler = @precio_alquiler_base* Parcela.FACTORALQUILERCALLE*(1+@num_casas*Parcela.FACTORALQUILERCASA+@num_hoteles*Parcela.FACTORALQUILERHOTEL)
    # alquiler = @precio_alquiler_base*(1+@num_casas+@num_hoteles*4.0)
  end

  def contruir_casa
    @num_casas += 1
    true
  end

  def construir_hotel
    @num_hoteles +=1
    true
  end

end

camino_ronda = Parcela.new("Camino de Ronda", 100.0, 50.0, 50.0)
camino_ronda.contruir_casa
camino_ronda.construir_hotel
camino_ronda.construir_hotel
print  "El precio del alquiler de "+ camino_ronda.nombre+ " es: "+ camino_ronda.precio_alquiler_completo.to_s
