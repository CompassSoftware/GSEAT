package selection;
import java.util.ArrayList;
/**
 * @version 1.0
 */
import java.util.List;
import java.util.Scanner;

public class ListOutput<T> {

    private int page = 1;

    public int totalPages = 0;

    private int pageRecorders;

    private int totalRows = 0;

    private int pageStartRow = 0;

    private int pageEndRow = 0;

    private boolean hasNextPage = false;

    private boolean hasPreviousPage = false;

    private List<T> list;

    public ListOutput(List<T> list, int pageRecorders) {
        init(list, pageRecorders);
    }


    public void init(List<T> list, int pageRecorders) {
        this.pageRecorders = pageRecorders;
        this.list = list;
        totalRows = list.size();
        hasPreviousPage = false;
        if ((totalRows % pageRecorders) == 0) {
            totalPages = totalRows / pageRecorders;
        } else {
            totalPages = totalRows / pageRecorders + 1;
        }

        if (page >= totalPages) {
            hasNextPage = false;
        } else {
            hasNextPage = true;
        }

        if (totalRows < pageRecorders) {
            this.pageStartRow = 0;
            this.pageEndRow = totalRows;
        } else {
            this.pageStartRow = 0;
            this.pageEndRow = pageRecorders;
        }
    }

    // judge if needs paging
    public boolean isNext() {
        return list.size() > 5;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public String toString(int temp) {
        String str = Integer.toString(temp);
        return str;
    }

    public void description() {

        String description = "the total data is: " + this.getTotalRows() + "  " +

                "the total page is: " + this.getTotalPages() + "  " +

                "the current page is: " + this.getPage() + "  " +

                "if has the previous page: " + this.isHasPreviousPage() + "  " +

                "if has the next page: " + this.isHasNextPage() + "  " +

                "the start colunm: " + this.getPageStartRow() + "  " +

                "the end colunm: " + this.getPageEndRow();

        System.out.println(description);
    }

    public List getNextPage() {
        page = page + 1;

        disposePage();

        System.out.println("the page is: " + page);
        this.description();
        return getObjects(page);
    }

    /**
     * ´¦Àí·ÖÒ³
     */
    private void disposePage() {

        if (page == 0) {
            page = 1;
        }

        if ((page - 1) > 0) {
            hasPreviousPage = true;
        } else {
            hasPreviousPage = false;
        }

        if (page >= totalPages) {
            hasNextPage = false;
        } else {
            hasNextPage = true;
        }
    }

    public List getPreviousPage() {

        page = page - 1;

        if ((page - 1) > 0) {
            hasPreviousPage = true;
        } else {
            hasPreviousPage = false;
        }
        if (page >= totalPages) {
            hasNextPage = false;
        } else {
            hasNextPage = true;
        }
        this.description();
        return getObjects(page);
    }

    /**
     * get the pages
     *
     * @param page
     * @return
     */
    public List<T> getObjects(int page) {
        if (page == 0) {
            this.setPage(1);
        } else {
            this.setPage(page);
        }
        this.disposePage();
        if (page * pageRecorders < totalRows) {
            // judge if is the end page
            pageEndRow = page * pageRecorders;
            pageStartRow = pageEndRow - pageRecorders;
        } else {
            pageEndRow = totalRows;
            pageStartRow = pageRecorders * (totalPages - 1);
        }

        List<T> objects = null;
        if (!list.isEmpty()) {
            objects = list.subList(pageStartRow, pageEndRow);
        }
        // this.description();
        return objects;
    }

    public List<T> getFistPage() {
        if (this.isNext()) {
            return list.subList(0, pageRecorders);
        } else {
            return list;
        }
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageEndRow() {
        return pageEndRow;
    }

    public void setPageEndRow(int pageEndRow) {
        this.pageEndRow = pageEndRow;
    }

    public int getPageRecorders() {
        return pageRecorders;
    }

    public void setPageRecorders(int pageRecorders) {
        this.pageRecorders = pageRecorders;
    }

    public int getPageStartRow() {
        return pageStartRow;
    }

    public void setPageStartRow(int pageStartRow) {
        this.pageStartRow = pageStartRow;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public static void addInput(List<String> list , ArrayList<String> input) {
        list.addAll(input);
    }
}
