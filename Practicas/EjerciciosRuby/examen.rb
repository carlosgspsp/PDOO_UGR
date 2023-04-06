class Padre
  @atributo_clase1 = 3
  @atributo_clase2 = 5
  @@atributo_clase3 = 7

  def self.salida
    puts "Ejecutando salida de Padre"
    puts @atributo_clase1+1
    puts @atributo_clase2+1 unless  @atributo_clase2.nil?
    puts @@atributo_clase3+1
  end

  def self.salida2
    puts "Ejecutando salida2 de Padre"
    salida
  end

end

class Hija < Padre
  @atributo_clase1 = 11
  @@atributo_clase3 = 13

  def self.salida
    puts "Ejecutando salida de Hija"
    super
  end

  def self.salida2
    puts "Ejecutando salida 2 de Hija"
    super
  end
end

Hija.salida2