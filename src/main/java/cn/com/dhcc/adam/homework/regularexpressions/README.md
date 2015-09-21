<html>
  <head>
    <meta name="generator"
    content="HTML Tidy for HTML5 (experimental) for Windows https://github.com/w3c/tidy-html5/tree/c63cc39" />
    <title></title>
  </head>
  <body>
    <p>The 
    <code>java.util.regex</code> package primarily consists of three classes: 
    <a class="APILink" target="_blank" href="https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html">
      <code>Pattern</code>
    </a> , 
    <a class="APILink" target="_blank" href="https://docs.oracle.com/javase/8/docs/api/java/util/regex/Matcher.html">
      <code>Matcher</code>
    </a> , and 
    <a class="APILink" target="_blank"
    href="https://docs.oracle.com/javase/8/docs/api/java/util/regex/PatternSyntaxException.html">
      <code>PatternSyntaxException</code>
    </a> .</p>
    <p>The metacharacters supported by this API are: &lt;([{\^-=$!|]})?*+.&gt;</p>
    <p>Character Classes</p>
    <table border="0" summary="regular expression constructs for the character classes">
      <tbody>
        <tr>
          <th id="h1">Construct</th>
          <th id="h2">Description</th>
        </tr>
        <tr>
          <td headers="h1">
            <code>[abc]</code>
          </td>
          <td headers="h2">a, b, or c (simple class)</td>
        </tr>
        <tr>
          <td headers="h1">
            <code>[^abc]</code>
          </td>
          <td headers="h2">Any character except a, b, or c (negation)</td>
        </tr>
        <tr>
          <td headers="h1">
            <code>[a-zA-Z]</code>
          </td>
          <td headers="h2">a through z, or A through Z, inclusive (range)</td>
        </tr>
        <tr>
          <td headers="h1">
            <code>[a-d[m-p]]</code>
          </td>
          <td headers="h2">a through d, or m through p: [a-dm-p] (union)</td>
        </tr>
        <tr>
          <td headers="h1">
            <code>[a-z&amp;&amp;[def]]</code>
          </td>
          <td headers="h2">d, e, or f (intersection)</td>
        </tr>
        <tr>
          <td headers="h1">
            <code>[a-z&amp;&amp;[^bc]]</code>
          </td>
          <td headers="h2">a through z, except for b and c: [ad-z] (subtraction)</td>
        </tr>
        <tr>
          <td headers="h1">
            <code>[a-z&amp;&amp;[^m-p]]</code>
          </td>
          <td headers="h2">a through z, and not m through p: [a-lq-z] (subtraction)</td>
        </tr>
      </tbody>
    </table>
    <p>Predefined Character Classes</p>
    <table border="0" summary="Predefined character classes">
      <tbody>
        <tr>
          <th id="h1">Construct</th>
          <th id="h2">Description</th>
        </tr>
        <tr>
          <td headers="h1">
            <code>.</code>
          </td>
          <td headers="h2">Any character (may or may not match line terminators)</td>
        </tr>
        <tr>
          <td headers="h1">
            <code>\d</code>
          </td>
          <td headers="h2">A digit: 
          <code>[0-9]</code></td>
        </tr>
        <tr>
          <td headers="h1">
            <code>\D</code>
          </td>
          <td headers="h2">A non-digit: 
          <code>[^0-9]</code></td>
        </tr>
        <tr>
          <td headers="h1">
            <code>\s</code>
          </td>
          <td headers="h2">A whitespace character: 
          <code>[ \t\n\x0B\f\r]</code></td>
        </tr>
        <tr>
          <td headers="h1">
            <code>\S</code>
          </td>
          <td headers="h2">A non-whitespace character: 
          <code>[^\s]</code></td>
        </tr>
        <tr>
          <td headers="h1">
            <code>\w</code>
          </td>
          <td headers="h2">A word character: 
          <code>[a-zA-Z_0-9]</code></td>
        </tr>
        <tr>
          <td headers="h1">
            <code>\W</code>
          </td>
          <td headers="h2">A non-word character: 
          <code>[^\w]</code></td>
        </tr>
      </tbody>
    </table>
    <p>Quantifiers</p>
    <table border="0" cellspacing="2" cellpadding="0" summary="table of greedy, reluctant, and possessive quantifiers">
      <tbody>
        <tr>
          <th id="h1">Greedy</th>
          <th id="h2">Reluctant</th>
          <th id="h3">Possessive</th>
          <th id="h4">Meaning</th>
        </tr>
        <tr>
          <td headers="h1">
            <code>X?</code>
          </td>
          <td headers="h2">
            <code>X??</code>
          </td>
          <td headers="h3">
            <code>X?+</code>
          </td>
          <td headers="h4">
          <code style="font-style: italic">X</code>, once or not at all</td>
        </tr>
        <tr>
          <td headers="h1">
            <code>X\**</code>
          </td>
          <td headers="h2"> 
            <code>X\*?</code>
          </td>
          <td headers="h3">
            <code>X\*+</code>
          </td>
          <td headers="h4">
          <code style="font-style: italic">X</code>, zero or more times</td>
        </tr>
        <tr> 
          <td headers="h1">
            <code>X+</code>
          </td>
          <td headers="h2">
            <code>X+?</code>
          </td>
          <td headers="h3">
            <code>X++</code>
          </td>
          <td headers="h4">
          <code style="font-style: italic">X</code>, one or more times</td>
        </tr>
        <tr>
          <td headers="h1">
            <code>X{n}</code>
          </td>
          <td headers="h2">
            <code>X{n}?</code>
          </td>
          <td headers="h3">
            <code>X{n}+</code>
          </td>
          <td headers="h4">
          <code style="font-style: italic">X</code>, exactly 
          <i>
            <code>n</code>
          </i> times</td>
        </tr>
        <tr>
          <td headers="h1">
            <code>X{n,}</code>
          </td>
          <td headers="h2">
            <code>X{n,}?</code>
          </td>
          <td headers="h3">
            <code>X{n,}+</code>
          </td>
          <td headers="h4">
          <code style="font-style: italic">X</code>, at least 
          <i>
            <code>n</code>
          </i> times</td>
        </tr>
        <tr>
          <td headers="h1">
            <code>X{n,m}</code>
          </td>
          <td headers="h2">
            <code>X{n,m}?</code>
          </td>
          <td headers="h3">
            <code>X{n,m}+</code>
          </td>
          <td headers="h4">
          <code style="font-style: italic">X</code>, at least 
          <i>
            <code>n</code>
          </i> but not more than 
          <i>
            <code>m</code>
          </i> times</td>
        </tr>
      </tbody>
    </table>
    <p>Capturing Groups</p>
    <ol>
      <li>
        <code>((A)(B(C)))</code>
      </li>
      <li>
        <code>(A)</code>
      </li>
      <li>
        <code>(B(C))</code>
      </li>
      <li>
        <code>(C)</code>
      </li>
    </ol>
    <p>Boundary Matchers</p>
    <table border="0" cellspacing="2" cellpadding="0" summary="a description of all boundary matchers">
      <tbody>
        <tr>
          <th id="h1">Boundary Construct</th>
          <th id="h2">Description</th>
        </tr>
        <tr>
          <td headers="h1">
            <code>^</code>
          </td>
          <td headers="h2">The beginning of a line</td>
        </tr>
        <tr>
          <td headers="h1">
            <code>$</code>
          </td>
          <td headers="h2">The end of a line</td>
        </tr>
        <tr>
          <td headers="h1">
            <code>\b</code>
          </td>
          <td headers="h2">A word boundary</td>
        </tr>
        <tr>
          <td headers="h1">
            <code>\B</code>
          </td>
          <td headers="h2">A non-word boundary</td>
        </tr>
        <tr>
          <td headers="h1">
            <code>\A</code>
          </td>
          <td headers="h2">The beginning of the input</td>
        </tr>
        <tr>
          <td headers="h1">
            <code>\G</code>
          </td>
          <td headers="h2">The end of the previous match</td>
        </tr>
        <tr>
          <td headers="h1">
            <code>\Z</code>
          </td>
          <td headers="h2">The end of the input but for the final terminator, if any</td>
        </tr>
        <tr>
          <td headers="h1">
            <code>\z</code>
          </td>
          <td headers="h2">The end of the input</td>
        </tr>
      </tbody>
    </table>
  </body>
</html>
