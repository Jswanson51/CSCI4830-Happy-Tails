package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Pet")
public class Pet {

		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private Integer id;
		
		@Column(name = "name")
		private String name;
		
		@Column(name = "age")
		private Integer age;
		
		@Column(name = "weight")
		private String weight;
		
		@Column(name = "species")
		private String species;
		
		@Column(name = "breed")
		private String breed;
		
		@Column(name =  "temperament")
		private String temperament;
		
		public Pet() {
		}
		
		public Pet(Integer id, String name, Integer age, String weight, String species, String breed, String temperament) {
			this.id = id;
			this.name = name;
			this.weight = weight;
			this.species = species;
			this.breed = breed;
			this.temperament = temperament;
		}
		
		public Pet(String name, Integer age, String weight, String species, String breed, String temperament) {
			this.name = name;
			this.weight = weight;
			this.species = species;
			this.breed = breed;
			this.temperament = temperament;
		}
		
		public Integer getId() {
			return id;
		}
		
		public void setId(Integer id) {
			this.id = id;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public Integer getAge() {
			return age;
		}
		
		public void setAge(Integer age) {
			this.age = age;
		}
		
		public String getWeight() {
			return weight;
		}
		
		public void setWeight(String weight) {
			this.weight = weight;
		}
		
		public String getSpecies() {
			return species;
		}
		
		public void setSpecies(String species) {
			this.species = species;
		}
		
		public String getBreed() {
			return breed;
		}
		
		public void setBreed(String breed) {
			this.breed = breed;
		}
		
		public String getTemperment() {
			return temperament;
		}
		
		public void setTemperment(String temperament) {
			this.temperament = temperament;
		}
		
		@Override
		   public String toString() {
		      return "Pet: " + this.id + ", " + this.name + ", " + this.age + ", " + this.weight + "," + this.species + "," + this.breed + "," + this.temperament;
		   }
		}
