CREATE TABLE public.queue
(
  queueid integer NOT NULL,
  name character varying(100) NOT NULL,
  destinationurl character varying(1000) NOT NULL,
  callbackurl character varying(1000) NOT NULL,
  createdon date NOT NULL,
  updatedon date NOT NULL,
  CONSTRAINT PRIMARY KEY (queueid)
);

CREATE TABLE public.request
(
  requestid integer NOT NULL,
  refid character varying(100) NOT NULL,
  requestcontent character varying(100) NOT NULL,
  request character varying(1000) NOT NULL,
  response character varying(1000) NOT NULL,
  createdon date NOT NULL,
  updatedon date NOT NULL,
  queueid integer NOT NULL,
  PRIMARY KEY (requestid),
  FOREIGN KEY (queueid) REFERENCES public.queue(queueid)
);


CREATE TABLE public.statusmaster
(
  statusid integer NOT NULL,
  name character varying(100) NOT NULL,
  PRIMARY KEY (statusid)
);

insert into public.statusmaster values(1,'CREATE');
insert into public.statusmaster values(2,'ENQUEUE');
insert into public.statusmaster values(3,'SEND');
insert into public.statusmaster values(4,'RECEIVED');
insert into public.statusmaster values(5,'FAILURE');
insert into public.statusmaster values(6,'RESPONDED');

CREATE TABLE public.requeststatus (
	requestid integer NOT NULL,
	statusid integer NOT NULL ,
	PRIMARY KEY (requestid, statusid),
	FOREIGN KEY (requestid) REFERENCES public.statusmaster(requestid),
	FOREIGN KEY (statusid) REFERENCES public.statusmaster(statusid)
);

