const modal = document.getElementById("myModal");

// Get the buttons that opens the modal
const btns = document.querySelectorAll('.signbtn'); 

// Get the <span> element that closes the modal
const span = document.getElementsByClassName("btn btn-full cancelbtn")[0];

// When the user clicks the button, open the modal 
[].forEach.call(btns, function(e) {
  e.onclick = function() {
  	modal.style.display = "block";
  }
})

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
$('.product .signbtn').on('click', function() {
    $('.product').removeClass('selected');
    $(this).parent().addClass('selected');
    $('.select').val($(this).parent().data('product'));
});