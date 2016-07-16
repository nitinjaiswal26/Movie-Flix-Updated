package io.egen.api.entity;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.NamedQueries;
	import javax.persistence.NamedQuery;
    import javax.persistence.OneToOne;
    import javax.persistence.Table;
	import org.hibernate.annotations.GenericGenerator;

	@Entity
	@Table
	@NamedQueries(@NamedQuery(name = "IMDBDetails.findById", query = "SELECT u FROM IMDBDetails u WHERE u.id=:pid"))
	public class IMDBDetails {

		@Id
		@GenericGenerator(strategy = "uuid2", name = "myuuid")
		@GeneratedValue(generator = "myuuid")
		private String id;
		private String imdbRating;
		private String imdbVotes;
		private String imdbID;
		private String Type;
		
		@OneToOne
		private Movie movie;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public Movie getMovie() {
			return movie;
		}
		public void setMovie(Movie movie) {
			this.movie = movie;
		}
		public String getImdbRating() {
			return imdbRating;
		}
		public void setImdbRating(String imdbRating) {
			this.imdbRating = imdbRating;
		}
		public String getImdbVotes() {
			return imdbVotes;
		}
		public void setImdbVotes(String imdbVotes) {
			this.imdbVotes = imdbVotes;
		}
		public String getImdbID() {
			return imdbID;
		}
		public void setImdbID(String imdbID) {
			this.imdbID = imdbID;
		}
		public String getType() {
			return Type;
		}
		public void setType(String type) {
			Type = type;
		}
		
		

}
