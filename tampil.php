<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
            <meta charset="utf-8">
                <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport">
                    <link href="assets\bootstrap\css\bootstrap.min.css" rel="stylesheet">
                        <link href="assets\css\fontawesome-free\css\all.min.css" rel="stylesheet">
                            <link href="assets\css\style.css" rel="stylesheet">
                                <title>
                                    Tampilkan Editor
                                </title>
                            </link>
                        </link>
                    </link>
                </meta>
            </meta>
        </meta>
    </head>
    <body style="background-color: #99ff99">
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-success">
	  <a class="navbar-brand font-weight-bold" href="index.php" style="color: black"><i class="fas fa-edit"></i> data editor</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>

	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav ml-auto">
	      <li class="nav-item active">
	        <a class="nav-link" href="cari.php" style="color: black">pencarian editor</a>
	      </li>
	      <li class="nav-item active">
	        <a class="nav-link" href="tampil.php" style="color: black">tampilkan editor</a>
	      </li>
	      <li class="nav-item active">
	        <a class="nav-link" href="about.php" style="color: black">tentang saya</a>
	      </li>
	    </ul>
	  </div>
	</nav>
        <!-- End Navbar -->

        <div class="container">
            <div class="row">
                <div class="col">
                    <div class="result d-flex justify-content-center mt-4"></div>
                </div>
            </div>
        </div>

        <script src="assets\bootstrap\js\jquery.min.js">
        </script>
        <script src="assets\bootstrap\js\bootstrap.min.js">
        </script>
                <script>

                let loading = '<img class="text-center" alt="loading......" class="ml-auto" src="assets\\img\\loading.gif" width="30%">'
                $(".result").html(loading);
                loadData();

        function loadData(){
            $.get('core/get.php?q=show', function(data){
                $(".result").html(data);
            });
        }
        </script>
    </body>
</html>
