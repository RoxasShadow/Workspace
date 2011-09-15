use ExtUtils::MakeMaker;


WriteMakefile(
	      NAME => "WWW::Google::PageRank",
	      VERSION_FROM => "lib/WWW/Google/PageRank.pm",
	      'dist' => { COMPRESS=>"gzip", SUFFIX=>"gz" },
	      AUTHOR => 'Yuri Karaban <tech@askold.net>',
	      PREREQ_PM => {
			    'LWP::UserAgent' => 0,
			    'URI::Escape' => 0
			   }
	     );
