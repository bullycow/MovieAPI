begin;

CREATE TABLE movie(
	id UUID, 
	title TEXT,
	release_date DATE,
	rating DECIMAL(3,1) CHECK(rating >= 0 AND rating <=10),
	revenue BIGINT,
	PRIMARY KEY(id)
);

commit;