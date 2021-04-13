<!-- Income Tax Calculator project php file -->
<html>

<head>
  <title>
    Income Tax Calculator
  </title>
</head>

<body align=center>

  <h1>Income Tax Department</h1>
  <h2>Goverment of India</h2>
  <br>
  <br>
  <h2>Tax Calculator</h2>

  <div id="textcall">
  <!-- input form sends post method to infile php on submit -->
    <form action="#" method="POST">
      <table align=center>
        <tr>
          <td>Assessment year
          <td><select name="assyear" id="assyear">
              <option value="1718">2017-2018</option>
              <option value="1819">2018-2019</option>
              <option value="1920">2019-2020</option>
              <option value="2021">2020-2021</option>
              <option value="2122">2021-2022</option>
            </select></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td>Net Annual Taxable Income
          <td> <input name="income" type="number" size="16" value="0"></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td>Gender </td>
          <td>
            <input type="radio" id="gm" value="M" name="gender" checked> Male
            <input type="radio" id="gf1" value="F" name="gender">Female
          </td>
        </tr>
        <tr>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td>Age </td>
          <td>
            <input type="radio" id="l1" name="age" value="l1" checked> Less than 60 <br />
            <input type="radio" id="g1" name="age" value="g1"> Greater than 60<br />
            <input type="radio" id="g2" name="age" value="g2"> Greater than 80
          </td>
        </tr>
        <tr>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td colspan="2" align="center"><input type="submit" value="Submit" name="submit"></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
        </tr>

    </form>
  </div>
</body>

</html>
<!-- php file  -->
<?php
$incomeTax = null;
$educationCess = null;
$totalTax = null;
if (isset($_POST["submit"])) {
  // get the SOAP Client
  $client = new SoapClient("http://localhost:8080/IncomeTaxCalculator/IncomeTaxCalculatorService?WSDL");
  // get the parameters from html file
  $assesment_year = $_POST["assyear"];
  $income = $_POST["income"];
  $gender = $_POST["gender"];
  $age = $_POST["age"];

  // create a parameters array
  $params = array(
    "ass_year" => $assesment_year,
    "income" => $income,
    "gender" => $gender,
    "age" => $age
  );
  // get the response from soapCall
  // call to function calculatTax with parameters
  $response = $client->__soapCall("calculateTax", array($params));
  // incometax is the first argument
  $incomeTax = $response->return[0];
  // education cess is the second argument
  $educationCess = $response->return[1];
  // total tax is the third argument
  $totalTax = $response->return[2];
  // print the result in html page
  echo "<table align=center>
  <tr>
          <td>Income Tax
          <td><input size=\"16\" readonly value=".$incomeTax."></td>
        </tr>
        <tr>
          <td>Educational Cess
          <td><input size=\"16\" value=" . $educationCess."></td>
        </tr>
        <tr>
          <td>Total Tax Liability
          <td><input size=\"16\" readonly  value=" . $totalTax . "></td>
        </tr>
      </table>";
}
?>