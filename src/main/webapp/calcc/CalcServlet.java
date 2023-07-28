package p;

import net.objecthunter.exp4j.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Calc", urlPatterns = {"/calc"})
public class CalcServlet extends HttpServlet {

    String htmlTemplate
            = """
<!DOCTYPE html>
                  
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

        <title>Calc</title>

        <link rel="stylesheet" href="https://cdn.korzh.com/metroui/v4.5.1/css/metro-all.min.css" />
    </head>

    <body>
        <div class="container">
            <div class="grid">
                <div class="row">
                    <div class="cell-3">
                        <div class="container">
                            <div class="grid">
                                <div class="row">
                                    <div class="cell-12">
                                        <div>
                                            <form method="post" action="" id="calc_form"><input type="text" data-role="input" name="expression" value=":result:" id="display" readonly /></form>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="cell-3"><button class="button numpad">7</button></div>
                                    <div class="cell-3"><button class="button numpad">8</button></div>
                                    <div class="cell-3"><button class="button numpad">9</button></div>
                                    <div class="cell-3"><button class="button numpad">/</button></div>
                                </div>
                                <div class="row">
                                    <div class="cell-3"><button class="button numpad">4</button></div>
                                    <div class="cell-3"><button class="button numpad">5</button></div>
                                    <div class="cell-3"><button class="button numpad">6</button></div>
                                    <div class="cell-3"><button class="button numpad">*</button></div>
                                </div>
                                <div class="row">
                                    <div class="cell-3"><button class="button numpad">1</button></div>
                                    <div class="cell-3"><button class="button numpad">2</button></div>
                                    <div class="cell-3"><button class="button numpad">3</button></div>
                                    <div class="cell-3"><button class="button numpad">-</button></div>
                                </div>
                                <div class="row">
                                    <div class="cell-3"><button class="button numpad">0</button></div>
                                    <div class="cell-3"><button class="button" id="clear_button">C</button></div>
                                    <div class="cell-3"><button class="button" id="calculate_button">=</button></div>
                                    <div class="cell-3"><button class="button numpad">+</button></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="cell-3"></div>
                    <div class="cell-3"></div>
                    <div class="cell-3"></div>
                </div>
            </div>
        </div>

        <script src="https://cdn.korzh.com/metroui/v4.5.1/js/metro.min.js"></script>

        <script>
            $(function () {
                $('.numpad').click(numpad);
                $('#clear_button').click(clear);
                $('#calculate_button').click(calculate);
            });

            function numpad(event) {
                $('#display').val($('#display').val() + $(event.target).text());
            }

            function clear(event) {
                $('#display').val('');
            }

            function calculate(event) {
                $('#calc_form')[0].submit();
            }
        </script>
    </body>
</html>
""";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String html = htmlTemplate.replace(":result:", (String) (request.getSession().getAttribute("result")));
        request.getSession().setAttribute("result", null);
        try ( PrintWriter out = response.getWriter()) {
            out.println(html);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("result") == null) {
            request.getSession().setAttribute("result", "");
        }
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String expression = request.getParameter("expression");

        try {
            Expression e = new ExpressionBuilder(expression).build();
            String result = "" + (int) e.evaluate();
            request.getSession().setAttribute("result", result);
        } catch (IllegalArgumentException | ArithmeticException e) {
            request.getSession().setAttribute("result", e.getMessage());
        }

        response.sendRedirect("calc");
    }
}
